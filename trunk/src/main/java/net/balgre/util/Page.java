package net.balgre.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017-04-27 오후 3:00
 * Prac / net.balgre.service
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 *
 * @author 숨 크리에이티브 김진국
 * @version 1.0
 * @see
 * @since 2017/04/11
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/21  김진국          최초 생성
 *  </pre>
 */
public class Page {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int page;
    private int perPageNum;

    private int displayPageNum = 10;

//    private Criteria cri;





    private Page pagePage;

    public Page() {

        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPage(int page) {

        if (page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public void setPerPageNum(int perPageNum) {

        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPage() {
        return page;
    }

    public int getPageStart() {

        return (this.page - 1) * perPageNum;
    }

    public int getPerPageNum() {

        return this.perPageNum;
    }






    public void setCri(int page, int perPageNum) {
        this.page = page;
        this.perPageNum = perPageNum;
    }

//    public List<Page> getCri() {
//        getCri().add(getPage());
//        getCri().add(getPerPageNum());
//
//        return getCri();
//    }

    public Map<String, Object> getCri() {

        Map<String, Object> cri = new HashMap<>();
        cri.put("page", page);
        cri.put("perPageNum", perPageNum);

        return cri;

    }


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        calcData();
    }

    public int getTotalCount() {
        return totalCount;
    }

    private void calcData() {

        endPage = (int) (Math.ceil(pagePage.getPage() / (double) displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) pagePage.getPerPageNum()));

        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;

        next = endPage * pagePage.getPerPageNum() >= totalCount ? false : true;

    }



    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }



//    /**
//     * Make query string.
//     *
//     * @param page the page
//     * @return the string
//     */
//    public String makeQuery(int page) {
//
//        UriComponents uriComponents =
//                UriComponentsBuilder.newInstance()
//                        .queryParam("page", page)
//                        .queryParam("perPageNum", cri.getPerPageNum())
//                        .build();
//
//        return uriComponents.toUriString();
//    }
//
//
//    /**
//     * Make search string.
//     *
//     * @param page the page
//     * @return the string
//     */
//    public String makeSearch(int page) {
//
//        UriComponents uriComponents =
//                UriComponentsBuilder.newInstance()
//                        .queryParam("page", page)
//                        .queryParam("perPageNum", cri.getPerPageNum())
//                        .queryParam("searchType", ((SearchCriteria) cri).getSearchType())
//                        .queryParam("keyword", ((SearchCriteria) cri).getKeyword())
//                        .build();
//
//        return uriComponents.toUriString();
//    }
//
//    @Override
//    public String toString() {
//        return "PageMaker{" +
//                "totalCount=" + totalCount +
//                ", startPage=" + startPage +
//                ", endPage=" + endPage +
//                ", prev=" + prev +
//                ", next=" + next +
//                ", displayPageNum=" + displayPageNum +
//                ", cri=" + cri +
//                '}';
//    }
}
