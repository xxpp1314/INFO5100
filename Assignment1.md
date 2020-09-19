1. Design a course management system
- Course
  Data: Name, CourseNumber, MeetingTime, MeetingRoom, ClassSize
  Behaviors: 
 -Student
  Data: Name, loginCredential
  Behaviors: login, search, register, drop
 -CourseManagementWebsite
  Data: Administrator;
  Behaviors: allocateAdministrator, publishCourseInformation
 -Administrator
  Data: Name
  Behaviors: processStudentRegistration, allocateAviaibleSeat, allocateAdministrator, letInWaitingList
Sequence of invoking behaviors on objects
  Student Rachel;
  Student Oliver;
  Course INFO5100;
  CourseManagementWebsite myNEU;
  Administrator Susan = myNEU.allocateAdministrator;
  Rachel.login(loginCredential);
  Oliver.login(loginCredential);
  oliver.register(INFO5100);
  Rachel.search(INFO5100);
  if INFO5100 can be registered
    Rachel.register(INFO5100);
    if INFO5100 is Full and have waiting seats
        susan.processStudentRegigtration(Rachel);
        susan.letInWaitingList(Rachel);
        if Oliver.drop(INFO5100)；
          myNEU.publishCourseInformation(INFOR5100);
          susan.allocateAviaibleSeat(Rachel);
   else
    INFO5100 can't be registered
      
2. Design a pet adoption platform
-Pet
 Data: Name, Type, Characteristic
 Behaviors:
-Adopter
 Data: Name, Background, loginCredential, petPreference
 Behaviors: login, submitInformation, adoptPet
-Adoption Center
 Data: Name
 Behaviors: publishPetInfo, processAdopterInfo, 
 
    
