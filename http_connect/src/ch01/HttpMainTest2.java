package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dto.Post;

public class HttpMainTest2 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/10");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // REST API
			// connection.setRequestProperty("Content-type", "application/json");
			connection.connect();

			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer buffer = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					buffer.append(line + "\n");
				}
			} else if(statusCode == 404) {
				System.out.println("네이트워크 연결이 불안정합니다");
			}
			
			String str = buffer.toString(); 
			System.out.println(str);
			System.out.println("--------------------");
			
			Post post = new Post(); 
			System.out.println(str.substring(3, 14));
			post.userId =  Integer.parseInt(str.substring(3, 14));
			System.out.println(post.userId);
			// 문자열을 파싱해서 post 객체에 값을 담아 보세요. 
			// 출력까지 !!!
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
