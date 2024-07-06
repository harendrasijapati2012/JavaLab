class CollegeNameThread extends Thread {
    private String collegeName;

    public CollegeNameThread(String collegeName) {
        this.collegeName = collegeName;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(collegeName);
        }
    }

    public static void main(String[] args) {
        CollegeNameThread thread = new CollegeNameThread("NCIT");
        thread.start();
    }
}
