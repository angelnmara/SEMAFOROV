package lamarrulla.com.Utils;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ValidaGcloudAcces {
	public void validaAccess() {
		// If you don't specify credentials when constructing the client, the
		// client library will look for credentials in the environment.

		Storage storage = StorageOptions.getDefaultInstance().getService();

		Page<Bucket> buckets = storage.list();
		for (Bucket bucket : buckets.iterateAll()) {
		  // do something with the info
			System.out.println(bucket.getName());
		}
	}
}
