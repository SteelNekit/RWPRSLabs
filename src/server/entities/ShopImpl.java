package server.entities;

import org.xml.sax.SAXException;
import server.utils.XMLHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop{
    private Map<Integer, ArrayList<Employee>> employees;
    private List<Article> articles;

    public ShopImpl() throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src\\server\\resources\\source.xml"), handler);

        this.employees = handler.getEmployees();
        this.articles = handler.getArticles();
    }

    @Override
    public Employee GetMostCoolEmployee() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Employee>> pair : employees.entrySet()) {
            employeeList.addAll(pair.getValue());
        }
        Employee coolEmployee = employeeList.get(0);
        for (Employee employee : employeeList) {
            if (employee.getDaySold() > coolEmployee.getDaySold()) coolEmployee = employee;
        }
        return coolEmployee;
    }

    @Override
    public double AverageSoldedItems() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Employee>> pair : employees.entrySet()) {
            employeeList.addAll(pair.getValue());
        }
        double sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getDaySold();
        }
        return sum / employeeList.size();
    }

    @Override
    public void inFile() throws IOException {
        FileWriter writer = new FileWriter("src/app.server.resources/notes3.txt");
        writer.write(toString() + '\n');
        writer.write("Самый крутой человек дня:");
        writer.write(GetMostCoolEmployee().toString() + '\n');
        writer.write("В среднем за этот день продано: " + AverageSoldedItems() + " единиц товара");
        writer.close();
    }

    @Override
    public boolean isAlive() throws RemoteException {
        System.out.println("Оу, я чувствую чьё то давление");
        return true;
    }
}
