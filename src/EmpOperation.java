import java.util.*;
import java.util.stream.Collectors;

public class EmpOperation {

    public  static void main(String org[]){

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        System.out.println("################# How many male and female employees are there in the organization?");
        Map<String, Long> numberOfMaleOrFemale = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(numberOfMaleOrFemale);

        List<String> department = employeeList.stream()
                .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        department.forEach(System.out::println);

        System.out.println("################# Get the Average In ######################");
        Map<String, Double> averageAgeEmployee = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

        System.out.println(averageAgeEmployee);

        System.out.println("################# Get Details of Higher Paid Employee ############");
        Optional<Employee> hightPaidEmployee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        System.out.println(hightPaidEmployee.get());

        System.out.println("################# Get Details of Employee join after 2015 ############");

        List<Employee> joinaft2015 = employeeList.stream().filter(e ->e.getYearOfJoining()>2015).collect(Collectors.toList());

        List<String> joiningname = employeeList.stream().filter(e ->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());

        joiningname.forEach(System.out::println);


        System.out.println("################# Count the number of Employee in Each department ############");

        Map<String, Long> departmentvsEmployee =employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.println(departmentvsEmployee);

        System.out.println("################# average salary of each department  ############");

        Map<String, Double> getAverageSallary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(getAverageSallary);


        Optional<Employee> averageSallary = employeeList.stream()
                .collect(Collectors.averagingDouble( Comparator.comparing(Employee::getSalary) ));


        System.out.println( "averageSallary "+ averageSallary);


        System.out.println("################# youngest male employee in the product development department  ############");

        Optional<Employee> young = employeeList.stream().filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development")
                .min(Comparator.comparingInt(Employee::getAge));

        Optional<Employee> young = employeeList.stream().filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development")
                .min(Comparator.comparingInt(Employee::getAge));


        System.out.println(young.get());

        System.out.println("################# most working experience in the organization ############");
        Optional<Employee> expriceEmp = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining));

        System.out.println(expriceEmp.get());

        System.out.println("################# How many male and female employees " +
                "are there in the sales and marketing team? ############");
        Map<String, Long> femalesalesAndMarket = employeeList.stream()
                .filter( e ->e.getDepartment()=="Sales And Marketing")
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(femalesalesAndMarket);


        System.out.println("################# What is the average salary " +
                "of male and female employees? ############");
        Map<String, Double> averageSalaryGen = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryGen);

        Double averageSalary = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(averageSalary);


        System.out.println("################# Separate the employees who are younger or " +
                "equal to 25 years from those employees who are older than 25 years? ############");
        List<Employee> younger25 = employeeList.stream().filter(e->e.getAge()<=25)
                .collect(Collectors.toList());
        System.out.println(younger25);


        System.out.println("################# Assending and desc ############");

        List<Employee> empdesc = employeeList.stream().
        sorted( (e1,e2)-> e2.getId()-e1.getId() )
        .collect(Collectors.toList());

        System.out.println(empdesc);

        List<Employee> empasc = employeeList.stream().
                sorted( (e1,e2)-> e1.getId()-e2.getId() )
                .collect(Collectors.toList());

        System.out.println(empasc);


        List<String> employeeName = employeeList.stream().map(Employee::getName).distinct().collect(Collector.toList());

        System.out.println(employeeName);
    }
}
