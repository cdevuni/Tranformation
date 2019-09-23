package com.chandra.transform;

import java.awt.geom.Point2D;

public class Geo {

	private String type;
	private Point2D.Double coordinates;
	
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
	 * @return the coordinates
	 */
	public Point2D.Double getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Point2D.Double coordinates) {
		this.coordinates = coordinates;
	}
	
}
