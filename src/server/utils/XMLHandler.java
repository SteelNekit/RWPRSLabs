package server.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import server.entities.Article;
import server.entities.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLHandler extends DefaultHandler {
    public static final String ELEMENT_SECTOR = "sector";
    public static final String ELEMENT_EMPLOYEE = "employee";
    public static final String ELEMENT_ARTICLE = "article";
    public static final String FIELD_NAME_NUMBER = "number";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_SPECIALIZATION = "specialization";
    public static final String FIELD_NAME_DAYSOLD = "daysold";
    public static final String FIELD_NAME_TITLE = "title";
    public static final String FIELD_NAME_COST = "cost";
    public static final String FIELD_NAME_DESCRIPTION = "description";

    private final Map<Integer, ArrayList<Employee>> employees = new HashMap<Integer, ArrayList<Employee>>();
    private final List<Article> articles = new ArrayList<Article>();
    int sectorId = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals(ELEMENT_SECTOR)){
            sectorId = Integer.parseInt(attributes.getValue(FIELD_NAME_NUMBER));
        }
        if (qName.equals(ELEMENT_EMPLOYEE)) {
            String name = attributes.getValue(FIELD_NAME_NAME);
            String specialization = attributes.getValue(FIELD_NAME_SPECIALIZATION);
            int daySold = Integer.parseInt(attributes.getValue(FIELD_NAME_DAYSOLD));
            if (employees.containsKey(sectorId)) {
                employees.get(sectorId).add(new Employee(name,specialization,daySold,sectorId));
            } else {
                ArrayList<Employee> buf = new ArrayList<>();
                buf.add(new Employee(name,specialization,daySold,sectorId));
                employees.put(sectorId, buf);
            }
        }
        if(qName.equals(ELEMENT_ARTICLE)){
            String title = attributes.getValue(FIELD_NAME_TITLE);
            float cost = Float.parseFloat(attributes.getValue(FIELD_NAME_COST));
            String description = attributes.getValue(FIELD_NAME_DESCRIPTION);
            articles.add(new Article(title,cost,description));
        }
    }

    public Map<Integer, ArrayList<Employee>> getEmployees(){
        return employees;
    }

    public List<Article> getArticles(){
        return articles;
    }
}
