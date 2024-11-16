import java.util.Scanner;

public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }

    /**
     * Menampilkan todo ke List
     */
    public static void showToDoList() {
        System.out.println("================");
        System.out.println("TODO LIST: ");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;
            if (todo != null) {
                System.out.println( no + ". " + todo);
            }
        }
    }

    /**
     * menambahkan todo ke List
     */
    public static void testShowToDoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Study Kasus Membuat Java Dasar : Aplikasi Todolist";
        showToDoList();
    }

    public static void testAddToDoList() {
        for (int i = 1; i < 25; i++) {
            addToDoList("contoh To do Ke " + i);
        }
        showToDoList();
    }

    /**
     * menambahkan todo ke List
     */
    public static void addToDoList(String todo) {
        // cek apakah data model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
               // kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resizxe ukuran array 2x lipat
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan posisi data array null
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    /**
     * checking model todo ke List
     */
    private static boolean isModelAvailable() {
        Boolean result = true;
        for(int i = 0; i < model.length; i++) {
            if(model[i] != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * menghapus todo ke List
     */
    public static boolean removeToDoList(Integer number) {
        if((number-1) >= model.length){
            return false;
        }
        if(model[number-1] == null) {
            return false;
        }

        for (int i = (number -1); i < model.length; i++) {
            if(i == (model.length - 1)) {
                model[i] = null;
            }else {
                model[i] = model[i+1];
            }
        }
        return true;
    }

    /**
     * menampilkan veiw todo ke List
     */
    public static void viewShowToDoList() {
        while (true) {
            showToDoList();
            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")) {
                viewRemoveToDoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilih tidak ditemukan");
            }
        }
    }

    /**
     * menambah view todo ke List
     */
    public static void viewAddToDoList() {
        System.out.println("Add Todo List : ");
        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            addToDoList(todo);
        }
    }

    /**
     * menghapus todo ke List
     */
    public static void viewRemoveToDoList() {
        System.out.println("Menghapus TodoList");
        var number = input("Nomor yang dihapus (x Jika Batal)");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("gagal Menghapus todoList : " + number);
            }
        }
    }

    public static String input (String dataInput){
        System.out.print(dataInput + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("hi nama " +name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * test hapus data todo ke List
     */
    public static void testRemoveToDoList() {
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");

        var result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static void testviewRemoveToDoList(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");
        showToDoList();
        viewRemoveToDoList();
        showToDoList();
    }

    public static void testviewAddToDoList(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");
        viewShowToDoList();
        showToDoList();
    }

    public static void testViewShowTodoList(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");
        viewShowToDoList();
    }
}
