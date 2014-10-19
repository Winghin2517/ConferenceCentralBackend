package com.google.devrel.training.conference.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

//custom servlet to return the servingurl back to the android app for use.

public class SendServingUrlServlet extends HttpServlet {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
    private static final Logger LOG = Logger.getLogger(
            SendConfirmationEmailServlet.class.getName());
    
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
			
		List<BlobKey> blobs = blobstoreService.getUploads(request).get("file");
		BlobKey blobKey = blobs.get(0);

		ImagesService imagesService = ImagesServiceFactory.getImagesService();
		ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKey);

		String servingUrl = imagesService.getServingUrl(servingOptions);

		res.setStatus(HttpServletResponse.SC_OK);
		res.setContentType("application/json");

		JSONObject json = new JSONObject();
		try {
			json.put("servingUrl", servingUrl);
			json.put("blobKey", blobKey.getKeyString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			LOG.log(Level.WARNING, String.format("Failed to send back serving URL %s", servingUrl), e);
		}

		PrintWriter out = res.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
	}
	
	
}
