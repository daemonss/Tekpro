package university;
//Coupling tinggi (tergantung 5 kelas)//
public class UniversitySystem {
    private Student student;
    private Professor professor;
    private Course course;
    private Finance finance;
    private Logger logger;

    public UniversitySystem() {
        this.student = new Student();
        this.professor = new Professor();
        this.course = new Course();
        this.finance = new Finance();
        this.logger = new Logger();
    }

    // Method terkait mahasiswa
    public void enrollStudent(String name) {
        student.setName(name);
        finance.calculateTuition(name);
        logger.log("Student enrolled: " + name);
    }

    // Method terkait dosen
    public void assignProfessor(String subject) {
        professor.setSubject(subject);
        course.setProfessor(professor);
    }

    // Method terkait keuangan
    public void processPayment(String studentId) {
        finance.verifyPayment(studentId);
        logger.log("Payment processed for: " + studentId);
    }

    // Method tidak terkait (cohesion rendah)
    public void backupDatabase() {
        logger.log("Database backup started");
    }
}