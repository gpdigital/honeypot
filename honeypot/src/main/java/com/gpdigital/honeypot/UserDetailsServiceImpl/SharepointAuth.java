package com.gpdigital.honeypot.UserDetailsServiceImpl;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SharepointAuth {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println("Status for " + "test.user" + " -> " + checkCredentials("test.user", "abcxyz"));

	}

	/**
	 * 
	 * @param user
	 *            - username without domain
	 * @param pass
	 *            - password
	 * @return 200 - if authentication succeeds 401 - denied
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static int checkCredentials(String user, String pass) throws IOException, ClientProtocolException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(user, pass, "", "dir"));

		HttpHost target = new HttpHost("ts.accenture.com", 443, "https");

		// Make sure the same context is used to execute logically related
		// requests
		HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);

		// This will trigger NTLM authentication
		HttpGet httpget = new HttpGet("/_vti_bin/authentication.asmx");
		CloseableHttpResponse resp = httpclient.execute(target, httpget, context);

		int respStatus = resp.getStatusLine().getStatusCode();

		resp.close();
		httpclient.close();

		return respStatus;
	}

}
