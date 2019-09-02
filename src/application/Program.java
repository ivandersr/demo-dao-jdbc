package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);;	
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		
		list = sellerDao.findAll();
		list.forEach(System.out::println);;		
		
		System.out.println("\n=== TEST 4: seller insert ===");

		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000., department);
		
		sellerDao.insert(newSeller);
		System.out.println("Vendedor inserido. Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller insert ===");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completo");
		
		System.out.println("\n=== TEST 6: seller insert ===");
		
		System.out.print("Informe um id para o teste delete: ");
		int id = sc.nextInt();
		sc.close();
		sellerDao.deleteById(id);
		System.out.println("Delete completo");
	}

}
