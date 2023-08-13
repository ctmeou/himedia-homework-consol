package com.homework.consol;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.homework.consol.Template.getSqlSession;

public class CategoryService {

    private CategoryMapper categoryMapper;

    public List<CategoryDTO> selectAllRestaurant() {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<CategoryDTO> restaurantList = categoryMapper.selectAllRestaurant();

        sqlSession.close();

        return restaurantList;
    }

    public void searchCategoryBySupRestaurant(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<CategoryDTO> categoryList = categoryMapper.searchCategoryBySupRestaurant(searchCriteria);

        if (categoryList != null && categoryList.size() > 0){
            categoryList.forEach(System.out::println);
        } else {
            System.out.println("\n조회하신 지역이 없습니다.");
        }
        sqlSession.close();
    }

    public boolean registRestaurant(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.insertCategory(category);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return  result > 0;
    }

    public boolean updateRestaurant(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.updateCategory(category);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteRestaurant(int code) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.deleteCategory(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
