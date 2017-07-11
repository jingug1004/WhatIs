/**
 * Created by user on 2017-04-13 오전 9:03
 * Prac / net.balgre.persistence
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author 숨 크리에이티브 김진국
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/21  김진국          최초 생성
 *  </pre>
 * @since 2017/04/11
 */


package net.balgre.persistence;

import net.balgre.domain.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 2017-04-13 오전 9:03
 * Prac / net.balgre.persistence
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author 숨 크리에이티브 개발팀 김진국
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/21  김진국          최초 생성
 *  2017/05/27  이몽룡          인증이 필요없는 URL을 패스하는 로직 추가
 *  </pre>
 * @since 2017/04/10
 */


public interface GitHubService {

//    @GET("repos/{owner}/{repo}/contributors")
//    Call<List<Contributor>> repoContributors(
//            @Path("owner") String owner
//            , @Path("repo") String repo);

    @GET("api/main")
    Call<MainResponse> getMainResponse();


}
