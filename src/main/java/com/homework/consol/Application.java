package com.homework.consol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryController categoryController = new CategoryController();

        do {
            System.out.println("\n========== 전국 채식 식당 관리 ==========");
            System.out.println("1. 운영 중인 식당 전체 조회하기");
            System.out.println("2. 지역별 식당 조회하기");
            System.out.println("3. 신규 식당 추가하기");
            System.out.println("4. 식당 정보 수정하기");
            System.out.println("5. 식당 삭제하기");
            System.out.print("\n식당 관리 번호 입력 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1 : categoryController.selectAllRestaurant(); break;
                case 2 : chooseSubRestaurant(); break;
                case 3 : categoryController.registRestaurant(inputRestaurant()); break;
                case 4 : categoryController.updateRestaurant(updateRestaurant()); break;
                case 5 : categoryController.delectRestaurant(deleteAllRestaurant()); break;
                default :
                    System.out.println("\n번호 확인 후 다시 입력해주세요.");
            }

        } while (true);
    }


    private static void chooseSubRestaurant() {
        Scanner sc = new Scanner(System.in);
        CategoryService categoryService = new CategoryService();
        do {
            System.out.println("\n========== 지역별 식당 조회하기 ==========");
            System.out.println("1. 식당 조회하기");
            System.out.println("2. 이전 메뉴로");
            System.out.print("\n번호를 입력하세요 : ");

            int no = sc.nextInt();
            switch (no) {
                case 1 : categoryService.searchCategoryBySupRestaurant(inputSubRestaurant()); break;
                case 2 : return;
            }
        } while (true);
    }

    private static SearchCriteria inputSubRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 지역의 이름을 입력하세요.\n1.서울 \n2.경상도 \n3.제주 \n4.강원 \n5.전라도\n=> ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static Map<String, String> inputRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========== 식당 정보 입력 ==========");
        System.out.print("지역 코드를 입력하세요 : ");
        String areaCode = sc.nextLine();
        System.out.print("식당 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("음식 종류를 입력하세요 : ");
        String type = sc.nextLine();
        System.out.print("채식 종류를 입력하세요 : ");
        String step = sc.nextLine();
        System.out.print("인기 메뉴를 입력하세요 : ");
        String menu = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("areaCode", areaCode);
        parameter.put("name", name);
        parameter.put("type", type);
        parameter.put("step",step);
        parameter.put("menu",menu);

        return parameter;
    }

    private static Map<String, String> updateRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========== 수정할 식당 정보 입력 =========");
        System.out.print("식당 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("지역 코드를 입력하세요 : ");
        String areaCode = sc.nextLine();
        System.out.print("식당 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("음식 종류를 입력하세요 : ");
        String type = sc.nextLine();
        System.out.print("채식 종류를 입력하세요 : ");
        String step = sc.nextLine();
        System.out.print("인기 메뉴를 입력하세요 : ");
        String menu = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("areaCode", areaCode);
        parameter.put("name", name);
        parameter.put("type", type);
        parameter.put("step", step);
        parameter.put("menu", menu);

        return parameter;
    }

    private static Map<String, String> deleteAllRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========== 삭제할 식당 입력 ==========");
        System.out.print("식당 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }
}
