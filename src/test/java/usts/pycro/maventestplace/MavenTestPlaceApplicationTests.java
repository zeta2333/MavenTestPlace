package usts.pycro.maventestplace;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MavenTestPlaceApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void testFileRename() {
        // File file = new File("d.txt");
        // System.out.println(file.exists());
        // File renameFile = FileUtil.rename(file, "e.txt", true);
        System.out.println(RandomUtil.randomString(16));
        // System.out.println(renameFile.exists());
        // Conclusion: hutool的FileUtil.rename方法执行完，源文件必定消失。
    }

    @Test
    public void testSplitFileName() {
        String originalFileName = "test2_dsfaf1231231312_18783340473_13570652624_18442523697_16657640080_16682931105_15757960736_18755740496_15242257078.xml";
        String splitInfo = originalFileName.split("\\.")[0];
        String[] split = splitInfo.split("_");
        if (split.length >= 3) {
            List<String> phones = new ArrayList<>();
            for (int i = 2; i < split.length; i++) {
                phones.add(split[i]);
            }
            phones.forEach(System.out::println);
        }
    }

    @Test
    public void testListToString() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        String format = String.format("The content of the list are %s", list);
        System.out.println(format);
    }

    @Test
    public void testFileSize() {
        File file = new File("3dCampus.zip");
        System.out.println(file.length() / 1024);
    }

    @Test
    @SuppressWarnings("all")
    public void testStringContains() {
        System.out.println("xxx-213-asd.txt".contains("xx"));
    }

    @Test
    public void testSubList() {
        List<Integer> originList = new ArrayList<>();
        int listSize = RandomUtil.randomInt(100);
        System.out.println("listSize = " + listSize);
        for (int i = 0; i < listSize; i++) {
            originList.add(i);
        }
        // 每7个打印一次
        int batchSize = 7;
        for (int i = 0; i < listSize; i += batchSize) {
            int endIdx = Math.min(i + batchSize, listSize);
            System.out.println(originList.subList(i, endIdx));
        }
    }

    @Test
    public void testTimeConvert() {
        Date date = new Date(1694716920000L);
        System.out.println(date);
    }

    @Test
    public void testStudent() {
        Student student1 = new Student();
        student1.setAge(18);
        student1.setName("Kight");
        student1.setGender("Male");
        student1.setEmail("Kight126@123.com");
        System.out.println(student1);
    }

    @Test
    public void testTeacher() {
        Teacher teacher = new Teacher();
        teacher.age = 30;
        teacher.name = "Pycro";
        teacher.email = "123@321.com";
        teacher.gender = "男";
        System.out.println(teacher);
    }

    @Test
    public void testDateTime() {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis() - 60 * 60 * 1000));
    }

    @Test
    public void testSHA256Algorithm() {
        try {
            String plain = "SHA-256";
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digest = md.digest(plain.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String curString = Integer.toHexString(0xff & b);
                if (curString.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(curString);
            }
            System.out.println(hexString);
            System.out.println(255 & 62);
            System.out.println(0xff & 62);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

class Student {
    private int age;
    private String name;
    private String gender;
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Teacher {
    public int age;
    public String name;
    public String gender;
    public String email;
}