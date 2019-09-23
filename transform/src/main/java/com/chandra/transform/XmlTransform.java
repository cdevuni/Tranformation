package com.chandra.transform;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class XmlTransform {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {

		List<Location> locations = parseXml(); //Get the xml conversion objects as list
		
        Gson g = new Gson();

        g = new GsonBuilder().setPrettyPrinting().create();
        
        HashMap<String, List<Location>> locationMap = new HashMap<String, List<Location>>();
        locationMap.put("locations", locations);
        
        //Convert list object to JSON format
        String jsonOutput =  g.toJson(locationMap);
       
        //Write json output to a file
        FileWriter file = new FileWriter("json_out.json");
        try {
        	file.write(jsonOutput);
        	System.out.println("Successfully copied object to file.");
        }catch(IOException e) {
        	e.printStackTrace();
        }finally {
        	file.flush();
        	file.close();
        }
        
	}
	
	public static List<Location> parseXml() throws ParserConfigurationException, SAXException, IOException {
		
	  List<Location> locations = new ArrayList<Location>();
	  Location location = null;
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("./incident.xml"));
      
      document.getDocumentElement().normalize();
      NodeList inclist = document.getElementsByTagName("incident");
      NodeList nList = document.getElementsByTagName("ev");
      
      for (int temp = 0; temp < nList.getLength(); temp++)
      {
    	  Node node = nList.item(temp);
    	  if (node.getNodeType() == Node.ELEMENT_NODE)
          {
    		  Element eElement = (Element) node;
    		  
    		  location = new Location();
    		  location.set_id(eElement.getElementsByTagName("id").item(0).getTextContent());
    		  location.setDescription(eElement.getElementsByTagName("text").item(0).getTextContent());
    		  
    		  NodeList nodeList = eElement.getElementsByTagName("loc");
    		  if("geo".equals(nodeList.item(0).getAttributes().getNamedItem("type").getNodeValue())) {
    			  
    			  //Add type and coordinates
    			  Geo geo = new Geo();
    			 
    			  Point2D.Double point = new Point2D.Double(Double.parseDouble(eElement.getElementsByTagName("geo").item(0).getAttributes().getNamedItem("lon").getNodeValue()),
    					  Double.parseDouble(eElement.getElementsByTagName("geo").item(0).getAttributes().getNamedItem("lat").getNodeValue()));
    			  geo.setType("Point");
    			  geo.setCoordinates(point);
    			  location.setGeo(geo);
    			  
    		  }else if("tmc".equals(nodeList.item(0).getAttributes().getNamedItem("type").getNodeValue())) {
    			  
    			  //Add table, id, direction
    			  Tmc tmc = new Tmc();
    			  
    			  Node pNode = inclist.item(0);
    			  Element peElement = (Element) pNode;
    			  
    			  NodeList elementsByTagName = peElement.getElementsByTagName("ti");
    			  
    			  tmc.setTable(elementsByTagName.item(0).getAttributes().getNamedItem("table").getNodeValue());
    			  tmc.setId(eElement.getElementsByTagName("start").item(0).getAttributes().getNamedItem("id").getNodeValue());
    			  tmc.setDirection(eElement.getElementsByTagName("start").item(0).getAttributes().getNamedItem("dir").getNodeValue());
    			  
    			  location.setTmc(tmc);
    		  }
    		  
    		  location.setEventCode(eElement.getElementsByTagName("ec").item(0).getTextContent());
    		  location.setSeverity(eElement.getElementsByTagName("se").item(0).getTextContent());
    		  
    		  nodeList = eElement.getElementsByTagName("valid");
    		  location.setValidStart(nodeList.item(0).getAttributes().getNamedItem("start").getNodeValue());
    		  location.setValidEnd(nodeList.item(0).getAttributes().getNamedItem("end").getNodeValue());
    		  
    		  location.setType("TrafficIncident");
    		  location.setLastUpdated(Instant.now().toString()); //Java 1.8 to get the current date/time
    		  
    	      locations.add(location);
          }
      }
      return locations;
	}

}
