package com.idea.example.dao;

import com.idea.example.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/*
* 通过jpa持久层操作接口 实现DAO层
* @Query内的Query和DTO字段对应, 定义了@Query可以无视方法名称
* @Modifying//加上@Modifying @Query可以用来修改和删除等
* */
//@RepositoryDefinition(domainClass = City.class, idClass = Long.class)
@Transactional(readOnly = true)//事务注解 整体只读(readOnly),内部重复可以覆盖
public interface CityDao extends JpaRepository<City, Long> {

    //返回类型[[value1,value2],[..]] or null
    //SQL字段需要 和 DTO输出对应
    @Query("SELECT id, cityName, description FROM City WHERE cityName LIKE ?1 AND id > ?2")
    List<City> findByCityNameLikeAndIdGreaterThan(@Param("cityName") String cityName, @Param("id") Long id);

    //返回类型[[value1,value2],[..]] or null
    //SQL字段需要 和 DTO输出对应
    @Query("SELECT id, cityName, description FROM City WHERE cityName LIKE ?1")
    List<City> findCityNameLike22(String cityName);

    //返回类型[{key:value}] or []
    //JPA通过方法名称来自动生成Query: cityName like 查询 并且 description = 查询 +（Is, Equals）
    //WHERE city_name like '#firstName' AND description = #description; (cityName + '%', description);
    List<City> findByCityNameLikeAndDescriptionIs(String cityName, String description);

    //返回类型{key:value} or null
    //使用原生查询语句
    //SQL字段写*为全部DTO需要有空参数生产者
    //表明需要使用原生t_city
    @Query(value = "SELECT * FROM t_city WHERE id = ?1", nativeQuery = true)
    City findById22(Long id);

    @Transactional//解覆盖了整体的readOnly，所以这个方法可以操作删改
    @Modifying
    @Query("DELETE FROM City WHERE id = ?1")
    int deleteIsId33(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM City WHERE id IN (?1)")
    int deleteInIds22(@Param(value = "ids") List<Long> ids);//返回成功删除个数

    @Transactional
    @Modifying
    @Query("UPDATE City SET cityName = ?1, description = ?2 WHERE id = ?3")
    int updateSetCityNameAndDescriptionInId(@Param(value = "cityName") String cityName,
                                            @Param(value = "description") String description,
                                            @Param(value = "id") Long id);
}
