import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Question 2
		List<Customer> listCusOutPut = customerGetData();
		List<Order> listOrderOutPut = orderGetData();
		
		//lambda Comparator
		Comparator<Customer> compareByTotal = (Customer o1, Customer o2) -> 
		o1.getTotal()-(o2.getTotal());
		Comparator<Customer> compareByName = (Customer o1, Customer o2) -> 
		o1.getName().compareTo(o2.getName());
		
		//Question 3
		writeCustomerNew(listCusOutPut,compareByName);
		
		//Question 4
		reportTotal(listCusOutPut, listOrderOutPut, compareByTotal);
	}
	
	//Question 4
	public static void reportTotal(List<Customer> listCusOutPut, List<Order> listOrderOutPut, Comparator<Customer> compareByTotal) throws IOException{
		for (Customer cus : listCusOutPut) {
			for (Order ord : listOrderOutPut) {
				if (cus.getId() == ord.getCustid()) {
					cus.setTotal(cus.getTotal() + ord.getTotal());
				}
			}
		}
		Collections.sort(listCusOutPut,compareByTotal.reversed());
		FileWriter fwriter = new FileWriter("report.txt");
		int index=0;
		fwriter.write("id,name,sex,total"+System.lineSeparator());
		for (Customer cus:listCusOutPut) {
			if(index<3) {
				fwriter.write(cus.getId() +","+ cus.getName() + ","+cus.getSex() + ","+cus.getTotal() +System.lineSeparator());
				index++;
			}
		}
		fwriter.close();	
	}
	
	//Question 3
	public static void writeCustomerNew(List<Customer> listCusOutPut, Comparator<Customer> compareByName) throws IOException {
		Collections.sort(listCusOutPut,compareByName);
		for (Customer cus : listCusOutPut) {
			System.out.println(cus);
		}
		FileWriter fwriter = new FileWriter("customerNew.txt");
		for (Customer str : listCusOutPut) {
			fwriter.write(str + System.lineSeparator());
		}
		fwriter.close();
	}

//	Read line of Object in file customers.txt
	public static List<Customer> customerGetData() throws FileNotFoundException, IOException {
		try (BufferedReader in = new BufferedReader(new FileReader("customers.txt"))) {
			String line;
			List<Customer> listCus = new ArrayList<Customer>();
			while ((line = in.readLine()) != null) {
				String[] temp = line.split(",");
				if (isStringInt(temp[0])) {
					Customer cus = new Customer();
					cus.setId(Integer.parseInt(temp[0]));
					cus.setName(temp[1]);
					cus.setSex(temp[2]);
					cus.setDob(temp[3]);
					listCus.add(cus);
				}
			}
			return listCus;
		}
	}

//	Read line of Object in file orders.txt
	public static List<Order> orderGetData() throws FileNotFoundException, IOException {
		try (BufferedReader in = new BufferedReader(new FileReader("orders.txt"))) {
			String line;
			List<Order> listOrder = new ArrayList<Order>();
			while ((line = in.readLine()) != null) {
				String[] temp = line.split(",");
				if (isStringInt(temp[0])) {
					Order ord = new Order();
					ord.setId(Integer.parseInt(temp[0]));
					ord.setCustid(Integer.parseInt(temp[1]));
					ord.setDescription(temp[2]);
					ord.setTotal(Integer.parseInt(temp[3]));
					ord.setOrderDate(temp[4]);
					listOrder.add(ord);
				}
			}
			return listOrder;
		}
	}
//Check id="id"
	public static boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
}
