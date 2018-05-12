package cn.colg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.ProductCategory;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface ProductCategoryMapper extends tk.mybatis.mapper.common.Mapper<ProductCategory> {

    /**
     * 通过类目编号批量查询
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> selectByCategoryType(@Param("categoryTypeList") List<Integer> categoryTypeList);
}