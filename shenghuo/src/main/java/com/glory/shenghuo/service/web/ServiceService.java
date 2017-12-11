package com.glory.shenghuo.service.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.api.image.pojo.ImagePojo;
import com.glory.shenghuo.api.service.param.ServiceInsertParam;
import com.glory.shenghuo.api.service.param.ServiceListParam;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.mapper.ImageMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import com.glory.shenghuo.util.ConstantUtils;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    /**
     * 服务mapper
     */
    @Autowired
    ServiceMapper serviceMapper;

    /**
     *图片mapper
     */
    @Autowired
    ImageMapper goodsImageMapper;


    /**
     * web添加服务
     * @param param
     * @return
     */
    public int addService(ServiceInsertParam param){
        String[] banners = {};

        String bannersStr = param.getBanners();

        if(!StringUtil.isEmpty(bannersStr)){
            banners = bannersStr.split("\\|");
        }

        if(banners.length>0){
            param.setServiceImg(banners[0]);
        }

        int count = serviceMapper.add(param);

        ImagePojo imagePojo = null;
        if(count>0){

            for (int i=0;i<banners.length;i++){
                imagePojo = new ImagePojo();
                imagePojo.setProductId(param.getId());
                imagePojo.setProductType(ConstantUtils.ProductType.SERVICE);
                imagePojo.setUrl(banners[i]);
                goodsImageMapper.insert(imagePojo);
            }
        }
        return count;
    }

    /**
     * 更新服务
     * @param pojo
     * @return
     */
    public int updateService(ServicePojo pojo){
        return serviceMapper.update(pojo);
    }

    /**
     * web服务列表
     * @param serviceListParam
     * @return
     */
    public PageInfos getServiceList(ServiceListParam serviceListParam){
        PageHelper.startPage(serviceListParam.getPageNum(),serviceListParam.getPageSize(),true);
        Page<ServicePojo> page = serviceMapper.getAllList(serviceListParam);
        PageInfo<ServicePojo> data = new PageInfo<>(page);
        return UtilTools.pageChange(data,page);
    }

    /**
     * 获取服务的详情
     * @param id
     * @return
     */
    public ServicePojo getServiceDetail(int id){
        return serviceMapper.getDetail(id);
    }

    //根据服务id修改其删除状态
    public int changeServiceDeleteFlag(int serviceId){
        return serviceMapper.changeServiceDeleteFlag(serviceId);
    }
}
