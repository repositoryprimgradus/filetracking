package com.pg.filetracking.fileupload.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileUpload;
@Repository
public class FileUploadDaoImpl implements FileUploadDao {
@Autowired

EntityManager entityManager;
	private static final String FILEUPLOADUDATE="update file_upload set fileName=:fileName,modifiedBy=:modifiedBy,modifiedDate=:modifiedDate where fileBarcode=:fileBarcode and fileSubType=:fileSubType ";
	private static final String FILECONTENTUDATE="update file_content set fileName=:fileName, fileContent=:fileContent where fileBarcode=:fileBarcode and fileSubType=:fileSubType";

	@Transactional
	@Override
	public Long updateFileupload(FileUpload fileupload, FileContent filecontent) {
		// TODO Auto-generated method stub
		   Query query=entityManager.createNativeQuery(FILEUPLOADUDATE);
		   Query querycontent=entityManager.createNativeQuery(FILECONTENTUDATE);
				query.setParameter("fileBarcode", fileupload.getFileBarcode());
				query.setParameter("fileSubType",fileupload.getFileSubType());
				query.setParameter("fileName", fileupload.getFileName());
				query.setParameter("modifiedBy", fileupload.getModifiedBy());
				query.setParameter("modifiedDate", fileupload.getModifiedDate());
				
				querycontent.setParameter("fileBarcode", filecontent.getFileBarcode());
				querycontent.setParameter("fileSubType",filecontent.getFileSubType());
				querycontent.setParameter("fileName", filecontent.getFileName());
				querycontent.setParameter("fileContent",filecontent.getFileContent());
				
		Long count=(long) query.executeUpdate();
		count=(long) querycontent.executeUpdate();
				
		return count;
	}
}
