package org.omg.restbase;

import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

public enum HttpRequestMethod {
	HttpGet {
		public HttpUriRequest createRequest(String url) {return new HttpGet(url);}
		},
	HttpPost {
		public HttpUriRequest createRequest(String url) {return new HttpPost(url);}
		},
	HttpPut {
		public HttpUriRequest createRequest(String url) {return new HttpPut(url);}
		},
	HttpDelete {
		public HttpUriRequest createRequest(String url) {return new HttpDelete(url);}
		},
	HttpPatch {
		public HttpUriRequest createRequest(String url) {return new HttpPatch(url);}
		};

	public HttpUriRequest createRequest(String url) {
		return null;
	}
}