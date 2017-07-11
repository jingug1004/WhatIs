//package net.balgre.util;
//
///**
// * Created by wtime on 2017-02-08.
// * What : DAO 처리를 도와줄 Criteria((판단이나 결정을 위한) 기준) 클래스.
// * Why : 파라미터가 여러개로 늘어나면 관리하기 어려워지기 때문에 아예 클래스로 만들어서 객체로 처리하는 것이 더 바람직. 나중에 계속해서 검색까지 많은 역할을 하게 되므로, 내용을 반드시 이해.
// * How : Criteria는 객체의 내부에 page와 perPageNum 속성을 보관하도록 하고, XML Mapper에서 사용하는 getter를 제공.
// * 코드를 간결하게 하는 방법 중 하나는 여러 개의 파라미터를 전달할 경우 객체로 처리하는 것이 더 쉽다는 것을 이용. 조금 번잡하고 귀찮은 작업을 해결!
// * 스프링 MVC는 파라미터를 수집하는 기능이 강력하기 때문에 여러 종류의 필요한 데이터를 하나의 클래스로 구성해도 작업의 양이 많이 늘어나지 않음. 작성한 Criteria는 필요한 경우 확장해서 사용할 수도 있음.
// * 굳이 Criteria를 작성하고 싶지 않다면, 파라미터를 두 개 이상 받도록 설계하면 됨. 하지만, 검색과 같은 기능이 붙게 되면 점점 전달되는 파라미터의 양이 늘어나게 되므로, 관리가 복잡해질 수 있음.
// */
//public class Criteria {
//
////    private int page;
////    private int perPageNum;
//
//    /**
//     * 특이한 점은 기본값으로 페이지 번호는 1페이지로 지정하고, 리스트당 데이터의 수는 10으로 지정해서 강제로 부여.
//     * 이후에 set 메소드를 이용하면서 사용자가 고의로 잘못 입력할 수 있는 값에 대해 필요한 데이터를 조정.
//     */
////    public Criteria() {
////
////        this.page = 1;
////        this.perPageNum = 10;
////    }
//
//    /**
//     * Sets page.
//     *
//     * @param page the page
//     */
////    public void setPage(int page) {
////
////        if (page <= 0) {
////            this.page = 1;
////            return;
////        }
////
////        this.page = page;
////    }
//
//
//    /**
//     * Sets per page num.
//     *
//     * @param perPageNum the per page num
//     */
////    public void setPerPageNum(int perPageNum) {
////
////        if (perPageNum <= 0 || perPageNum > 100) {
////            this.perPageNum = 10;
////            return;
////        }
////
////        this.perPageNum = perPageNum;
////    }
//
//    /**
//     * Gets page.
//     *
//     * @return the page
//     */
////    public int getPage() {
////        return page;
////    }
//
//    /**
//     * getPageStart()는 limit 구문에서 시작 위치를 지정할 때 사용. 예를 들어, 10개씩 출력하는 경우 3페이지의 데이터는 limit 20, 10과 같은 형태가 되어야 함.
//     * 계산 공식은   시작 데이터 번호 = (페이지 번호 - 1) * 페이지 당 보여지는 개수
//     *
//     * @return the page start
//     */
//// method for MyBatis SQL Mapper -
////    public int getPageStart() {
////
////        return (this.page - 1) * perPageNum;
////    }
//
//    /**
//     * getPerPageNum()은 limit 뒤의 숫자를 의미해서 한 페이지당 보여지는 개수를 의미.
//     *
//     * @return the per page num
//     */
//// method for MyBatis SQL Mapper -
////    public int getPerPageNum() {
////
////        return this.perPageNum;
////    }
//
////    @Override
////    public String toString() {
////        return "Criteria{" +
////                "page=" + page +
////                ", perPageNum=" + perPageNum +
////                '}';
////    }
//}
