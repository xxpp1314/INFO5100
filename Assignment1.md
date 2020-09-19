1. Design a course management system
- Course
  Data: Name, CourseNumber, MeetingTime, MeetingRoom, ClassSize
  Behaviors: 
 -Student
  Data: Name, loginCredential
  Behaviors: login, search, register, drop, wait
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
          Rachel.wait(INFO5100);
   else
    INFO5100 can't be registered
      
2. Design a pet adoption platform
 -Pet
  Data: Name, Type, Color, Characteristic
  Behaviors:
 -Adopter
  Data: Name, Background, loginCredential, petPreference, adoptionReason
  Behaviors: login, search, applyForAdopt, submitInfor, adoptPet
 -AdoptionCenter
  Data: Name
  Behaviors: publishPetInfo, processAdopterInfo, waitNextAdopter
Sequence of invoking behaviors on objects
  Adopter Rachel;
  Adopter Oliver;
  AdoptionCenter PetsHome;
  Rachel.login(loginCredential);
  Pet lucky = Rachel.search(type, Color, Characteristic);
  if lucky is in PetsHome 
    Rachel.applyForAdopt(lucky);
    Rachel.submitInfo(background, petPreference, adoptionReason);
    PetsHome.processAdopterInfo(Rachel.background, Rachel.petPreference, Rachel.adoptReason);
    if Rachel suit the adopt condition
      Rachel.adoptPet(lucky)；
    else
      PetsHome.waitNextAdopter(Oliver);
   else
      lucky can not be adopted;
 
3.Design an app to book airline ticket.
    
