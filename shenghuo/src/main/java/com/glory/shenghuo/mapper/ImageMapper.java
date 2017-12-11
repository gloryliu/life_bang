package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.image.param.GetImageParam;
import com.glory.shenghuo.api.image.pojo.ImagePojo;

import java.util.List;

public interface ImageMapper extends BaseMapper {

    /**
     * 新增图片
     * @param imagePojo
     * @return
     */
    int insert(ImagePojo imagePojo);

    /**
     * 删除图片
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 根据产品id和产品类型获取图片
     * @param param
     * @return
     */
    List<ImagePojo> getImagesByProductIdAndType(GetImageParam param);

}
