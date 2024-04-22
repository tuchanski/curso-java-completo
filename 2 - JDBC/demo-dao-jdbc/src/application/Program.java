package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("=== TEST 2: findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);

        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("=== TEST 3: findByAll ===");
        sellers = sellerDao.findAll();

        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("=== TEST 4: SellerInsert ===");
        Seller seller1 = new Seller(null, "Arion", "arion@gmail.com", new Date(), 3550.50, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted! New ID: " + seller1.getId());

        System.out.println("=== TEST 5: SellerUpdate ===");
        seller1 = sellerDao.findById(1);
        seller1.setName("Alecinho Ben10");
        sellerDao.update(seller1);
        System.out.println("Updated!");

        System.out.println("=== TEST 6: SellerDelete ===");
        System.out.print("\n- Enter an ID: ");
        int id = input.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted!");

        input.close();

    }
}