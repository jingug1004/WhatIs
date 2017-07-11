package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.controller.QnaController;
import net.balgre.domain.CommonResponse;
import net.balgre.domain.Qna;
import net.balgre.domain.QnaListResponse;
import net.balgre.domain.UserResponse;
import net.balgre.network.QnaRetroImpl;
import net.balgre.network.UserInfoRetroImpl;

@Service
public class QnaServiceImpl implements QnaService {


    @Override
    public CommonResponse qnaInsert1(Qna qna, String token) {
        // TODO Auto-generated method stub

        QnaRetroImpl QRI = new QnaRetroImpl();
        // 3. RetroImpl 인스턴스 생성, 이 부분에서 QnaRetroImpl의 생성자가 호출(실행)된다.

        // 4. 생성한 인스턴스의 qnaInsert2 메서드를 호출하면서 파라미터 전달
        CommonResponse res = QRI.qnaInsert2(token, qna);

        if (res == null) {
            return null;
        }

        if (res.getResultCode().equals("200")) {

            return res;
        } else {
            return null;
        }
    }


    @Override
    public QnaListResponse qnaListResponse(String token) {

        QnaRetroImpl QRI = new QnaRetroImpl();

        QnaListResponse res = QRI.qnaList2(token);

        if (res == null) {
            return null;
        }

        if (res.getResultCode().equals("200")) {

            return res;
        } else {
            return null;
        }
    }

    @Override
    public UserResponse getUserInfo(String token) {
        // TODO Auto-generated method stub

        UserInfoRetroImpl UIR = new UserInfoRetroImpl();

        UserResponse res = UIR.getUserInfo2(token);

        if (res == null) {
            return null;
        }

        if (res.getResultCode().equals("200")) {
            return res;
        } else {
            return null;
        }
    }


    @Override
    public QnaListResponse qnaDelete(String token, int id) {
        // TODO Auto-generated method stub

        QnaRetroImpl QRI = new QnaRetroImpl();

        QnaListResponse res = QRI.qnaDelete2(token, id);

        if (res == null) {
            return null;
        }
        if (res.getResultCode().equals("200")) {

            return res;
        } else {
            return null;
        }
    }

	/*@Override
	public Qna qnaDetail(String token) {
		// TODO Auto-generated method stub
		
		QnaRetroImpl QRI = new QnaRetroImpl();
		
		Qna qna = QRI.qnaDetail2(token);
		
		if (qna.getRegDate() == null) {
			return null;
		} else {
		}
			return qna;
	}*/

}
