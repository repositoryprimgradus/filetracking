package com.pg.filetracking.fileupload.dao;

import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileUpload;

public interface FileUploadDao {

	public Long updateFileupload(FileUpload fileupload,FileContent filecontent);
}
