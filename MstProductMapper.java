package jp.co.internous.ocean.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import jp.co.internous.ocean.model.domain.MstProduct;


@Mapper
public interface MstProductMapper {

	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();

	
    //productIdで情報を探す
	@Select("SELECT * FROM mst_product WHERE id = #{id}")
	List<MstProduct> findById(@Param("id") int id);

	
    //下記indexController.java
	List<MstProduct> findByProductNameAndCategoryId
    (@Param("productName") String[] productName,
     @Param("categoryId") int categoryId);

    List<MstProduct> findByCategoryId(@Param("categoryId") int categoryId);
    List<MstProduct> findByProductName(@Param("productName") String[] productName); 

}