package com.example.financingapplication.contracts;

public class Contract
{
  private Long   id;
  private String fileLocation;
  private String fileName;

    /*  ФАЙЛА(ДОГОВОРА) ТРЯБВА ДА СЪДЪРЖА:
          -Сумата, която банката е финансирала User(Supplier-role)
          -Date - дата на сключения договор
          -User(Factor-role) - името на банковия служител, който е одобрил финансирането
          -User(Supplier-role) - името на потребителя, който е подал молба за финансиране
  */

  public Contract()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getFileLocation()
  {
    return fileLocation;
  }

  public void setFileLocation(String fileLocation)
  {
    this.fileLocation = fileLocation;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
}
