package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class InteractionAPI {
	private final String httpsBaseUrl = "https://reqres.in/api";
	URL url;
	HttpsURLConnection connection;

	/**
	 * Returns the data sent by the server from the endpoint.
	 * 
	 * @param The
	 *            endpoint
	 * @return Data sent by the server
	 */
	public String get(String endPoint) {
		// example : endpoint = "/users"
		String data = "";

		try {
			url = new URL(httpsBaseUrl + "/" + endPoint);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");

			data = this.readResponse();
			connection.disconnect();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * Make a request to the server to create a new entity.
	 * 
	 * @param json
	 * @return
	 */
	public String post(String endpoint, String json) {
		String response = "";

		try {
			url = new URL(httpsBaseUrl + "/" + endpoint);
			connection = (HttpsURLConnection) url.openConnection();

			// Headers
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");

			writeData(json);
			response = readResponse();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private boolean writeData(String data) {
		BufferedWriter bw;

		// After getting the connection's output stream, we write data
		// and test if the object was created
		try {
			bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			bw.write(data);
			bw.flush();
			bw.close();

			if (connection.getResponseCode() != 201)
				return false;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	private String readResponse() {
		StringBuffer response = new StringBuffer();
		String inputline;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// Reading the response and closing the buffered reader
			while ((inputline = br.readLine()) != null) {
				response.append(inputline);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.toString();
	}
}
