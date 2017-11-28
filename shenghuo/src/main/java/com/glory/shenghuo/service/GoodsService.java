package com.glory.shenghuo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.api.goods.param.ChangeRecGoodsStateParam;
import com.glory.shenghuo.api.goods.param.GoodsInsertParam;
import com.glory.shenghuo.api.goods.param.GoodsListParam;
import com.glory.shenghuo.api.goods.pojo.GoodsImagePojo;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.mapper.GoodsImageMapper;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    /**
     * 商品操作
     */
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 商品图片操作
     */
    @Autowired
    private GoodsImageMapper goodsImageMapper;

    /**
     * 添加商品
     * @param goodsParam
     * @return
     */
    public int insert(GoodsInsertParam goodsParam){

        String[] banners = {};

        String bannersStr = goodsParam.getBanners();

        if(!StringUtil.isEmpty(bannersStr)){
            banners = bannersStr.split("\\|");
        }

        if(banners.length>0){
            goodsParam.setGoodsImg(banners[0]);
        }

        goodsParam.setGoodsPrice(goodsParam.getOriginalPrice()+goodsParam.getProfit());//商品价格为原始价格加利润
        int count = goodsMapper.insert(goodsParam);

        GoodsImagePojo imagePojo = null;
        if(count>0){

            for (int i=0;i<banners.length;i++){
                imagePojo = new GoodsImagePojo();
                imagePojo.setGoodsId(goodsParam.getId());
                imagePojo.setUrl(banners[i]);
                goodsImageMapper.insert(imagePojo);
            }
        }

        return count;
    }

    /**
     * web获取商品列表
     * @param goodsListParam
     * @return
     */
    public PageInfos getAllList(GoodsListParam goodsListParam){

        PageHelper.startPage(goodsListParam.getPageNum(),goodsListParam.getPageSize(),true);
        Page<GoodsPojo> goodsPojos = goodsMapper.getAllList(goodsListParam);
        PageInfo<GoodsPojo> data = new PageInfo<>(goodsPojos);
        return UtilTools.pageChange(data,goodsPojos);
    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    public GoodsPojo getGoodsById(int id){
        return goodsMapper.getDetail(id);
    }

    /**
     * 后台改变商品是否特卖
     * @param param
     * @return
     */
    public int changeRecGoodsState(ChangeRecGoodsStateParam param){
        return goodsMapper.changeRecGoodsState(param);
    }
}
