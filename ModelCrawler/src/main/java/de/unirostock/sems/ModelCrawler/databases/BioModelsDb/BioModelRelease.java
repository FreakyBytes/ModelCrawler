package de.unirostock.sems.ModelCrawler.databases.BioModelsDb;

import java.io.File;
import java.util.Date;
import java.util.List;

public class BioModelRelease implements Comparable<BioModelRelease> {
	
	private String releaseName;
	private String ftpDirectory;
	private Date releaseDate;
	
	private File archivFile = null;
	private File contentDir = null;
	
	private List<String> modelList;
	
	public BioModelRelease( String releaseName, String ftpDirectory, Date releaseDate, File archivFile ) {
		this.releaseName	= releaseName;
		this.ftpDirectory	= ftpDirectory;
		this.releaseDate	= releaseDate;
		this.archivFile 	= archivFile;
	}
	
	public BioModelRelease( String releaseName, String ftpDirectory, Date releaseDate ) {
		this.releaseName	= releaseName;
		this.ftpDirectory	= ftpDirectory;
		this.releaseDate	= releaseDate;
	}
	
	public String getReleaseName() {
		return releaseName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public File getArchivFile() {
		return archivFile;
	}
	public boolean setArchivFile(File archivFile) {
		//REMIND the archiv file could only be setted once!
		if( this.archivFile == null ) {
			this.archivFile = archivFile;
			return true;
		}
		else
			return false;
	}
	public List<String> getModelList() {
		return modelList;
	}
	public String getFtpDirectory() {
		return ftpDirectory;
	}

	public File getContentDir() {
		return contentDir;
	}

	public boolean setContentDir(File contentDir) {
		// REMIND the contentDir can only be setted once!
		if( this.contentDir == null ) {
			this.contentDir = contentDir;
			return true;
		}
		else
			return false;
	}

	public boolean isDownloaded() {
		return archivFile == null ? false : true;
	}
	
	public boolean isExtracted() {
		return contentDir == null ? false : true;
	}
	
	@Override
	public int compareTo( BioModelRelease model ) {
		return releaseDate.compareTo( model.getReleaseDate() );
	}
	
}
