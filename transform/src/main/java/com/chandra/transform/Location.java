package com.chandra.transform;

public class Location {

	private String _id;
	private String description;
	private Geo geo;
	private Tmc tmc;
	private String roadName;
	private String eventCode;
	private String severity;
	private String validStart;
	private String validEnd;
	private String type;
	private String lastUpdated;
	
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the geo
	 */
	public Geo getGeo() {
		return geo;
	}

	/**
	 * @param geo the geo to set
	 */
	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	/**
	 * @return the tmc
	 */
	public Tmc getTmc() {
		return tmc;
	}

	/**
	 * @param tmc the tmc to set
	 */
	public void setTmc(Tmc tmc) {
		this.tmc = tmc;
	}

	/**
	 * @return the roadName
	 */
	public String getRoadName() {
		return roadName;
	}

	/**
	 * @param roadName the roadName to set
	 */
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the validStart
	 */
	public String getValidStart() {
		return validStart;
	}

	/**
	 * @param validStart the validStart to set
	 */
	public void setValidStart(String validStart) {
		this.validStart = validStart;
	}

	/**
	 * @return the validEnd
	 */
	public String getValidEnd() {
		return validEnd;
	}

	/**
	 * @param validEnd the validEnd to set
	 */
	public void setValidEnd(String validEnd) {
		this.validEnd = validEnd;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
