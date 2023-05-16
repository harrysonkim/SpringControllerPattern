package file.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import file.dto.Filetest;

public class DownloadView extends AbstractView {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// 서블릿 컨텍스트 객체
	@Autowired
	ServletContext context;

	@Override
	protected void renderMergedOutputModel(

			Map<String, Object> model, // 모델값
			HttpServletRequest request, // 요청정보객체
			HttpServletResponse response // 응답정보 객체

	) throws Exception {

		logger.info("응답테스트");

//		// 응답 메시지 헤더 설정(Content-Type)
//		response.setContentType("text/html; charset=utf-8");
//		
//		// 응답 메시지 바디 설정
//		response.getWriter().println("<h1>직접 HTML 응답</h1>");

//---------------------------------------------------------		

		// 모델 값 가져오기
		Filetest downFile = (Filetest) model.get("downFile");
		logger.info("downFile {}", downFile);

		// 저장된 파일의 폴더 (upload)
		String path = context.getRealPath("upload");

		// 실제 업로드된 파일의 이름
		String filename = downFile.getStored_name();

		// 실제 파일 객체
		File src = new File(path, filename);

		logger.info("서버에 업로드된 파일 {}", src);
		logger.info("존재여부 {}", src.exists());

		// ---------------------------------------------------------

		// ** HTTP응답을 직접 구성하여 처리한다

		// ** HTTP Response HEADER정보를 작성해야하낟
		// Contnet-Type
		// ContnetLength
		// CharacterEncoding
		// Contnet-Disposition

		// ** HTTP Response BODY 데이터를 작성해야 한다
		// 파일 객체를 스트림으로 출력

		// ---------------------------------------------------------

		// -- 응답메시지의 HEADER영역 설정

		// 파일을 전송하는 콘텐트 타입 설정
		// application/octet-stream: 이진 데이터 형식을 표현하는 MIME Type
		// 모든 형식의 파일을 표현할 때 사용
		// 응답받은 브라우저는 응답 데이터를 무조건 파일로 다운받는다
		// 이떄, 파일의 이름은 URL의 마지막 단계(자원의 이름)를 따른다
		response.setContentType("application/octet-stream");

		// 응답 데이터의 크기 설정
//		response.setContentLength( (int)src.length() );
		response.setContentLengthLong(src.length());
		
		// 응답 데이터의 인코딩 설정
		response.setCharacterEncoding("UTF-8");

		// 브라우저가 다운로드한 파일의 이름 설정
		String outputName = URLEncoder.encode(downFile.getOrigin_name(), "UTF-8");
		
		outputName = outputName.replace("+", "%20");
		
		logger.info("outputName : {}", outputName);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + outputName + "\"");

		// ---------------------------------------------------------

		// -- 응답메시지의 BODY영역 설정

		//	서버 File => FileInputStream 입력 => HTTP Response OutPutStream출력
		
		// 서버의 파일 입력 스트림
		FileInputStream in = new FileInputStream(src);
		
		// 클라이언트 응답 출력 스트림
		OutputStream out = response.getOutputStream();
		
		FileCopyUtils.copy(in, out);
		
		
		
		
		
		
		
		// ---------------------------------------------------------
	}

}
