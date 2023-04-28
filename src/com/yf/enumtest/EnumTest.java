package com.yf.enumtest;

//Enums are a definition of a type, associated to a list of values
//The enums are sub classes of java.lang.Enum
enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

//Also enums can have declared a constructor
enum FileType {
    PDF(2), XLS(1), CSV(0);

    int fileValue;

    //VERY IMPORTANT. This constructor IS ONLY private, (Is not mandatory setting the access modifier, but in this case is private ONLY)
    //It means that cannot be used outside here. In case its removed class will be invalid
    FileType(int fileValue) {
        this.fileValue = fileValue;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        Week day = Week.MONDAY;

        if (day == Week.FRIDAY) {
            System.out.println("Happy day ;)");
        }

        switch (day) {
            case SUNDAY: //Its an error put Week.SUNDAY. In the case the CONSTANTS of ENUM are used directly
                System.out.println("Yahoo weekend");
                break;
            case SATURDAY:
                System.out.println("Yupii weekend");
                break;
            default:
                System.out.println("Not weekend :S");
                break;
        }

        FileType filePDF = FileType.PDF;
        System.out.println("filePDF.fileValue = " + filePDF.fileValue);

        //Enum inherits some methods like 
        //values(), name(), ordinal(), toString()
        for (Week d : Week.values()) {
            System.out.println("Day of week = " + d + ", Ordinal = " + d.ordinal());
        }

        //NOTE: the ordinal starts from 0, enum values are printed in the specified order
        for (FileType file : FileType.values()) {
            System.out.println("file = " + file + ", Ordinal = " + file.ordinal() + ", fileValue = " + file.fileValue);
        }
    }
}
