
package com.webwemser.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webwemser.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateMeet_QNAME = new QName("http://web/", "createMeet");
    private final static QName _CreateMeetResponse_QNAME = new QName("http://web/", "createMeetResponse");
    private final static QName _GetCategories_QNAME = new QName("http://web/", "getCategories");
    private final static QName _GetCategoriesResponse_QNAME = new QName("http://web/", "getCategoriesResponse");
    private final static QName _GetMeet_QNAME = new QName("http://web/", "getMeet");
    private final static QName _GetMeetResponse_QNAME = new QName("http://web/", "getMeetResponse");
    private final static QName _GetMeets_QNAME = new QName("http://web/", "getMeets");
    private final static QName _GetMeetsByCategory_QNAME = new QName("http://web/", "getMeetsByCategory");
    private final static QName _GetMeetsByCategoryResponse_QNAME = new QName("http://web/", "getMeetsByCategoryResponse");
    private final static QName _GetMeetsByUser_QNAME = new QName("http://web/", "getMeetsByUser");
    private final static QName _GetMeetsByUserResponse_QNAME = new QName("http://web/", "getMeetsByUserResponse");
    private final static QName _GetMeetsResponse_QNAME = new QName("http://web/", "getMeetsResponse");
    private final static QName _Init_QNAME = new QName("http://web/", "init");
    private final static QName _InitResponse_QNAME = new QName("http://web/", "initResponse");
    private final static QName _JoinMeet_QNAME = new QName("http://web/", "joinMeet");
    private final static QName _JoinMeetResponse_QNAME = new QName("http://web/", "joinMeetResponse");
    private final static QName _LeaveMeet_QNAME = new QName("http://web/", "leaveMeet");
    private final static QName _LeaveMeetResponse_QNAME = new QName("http://web/", "leaveMeetResponse");
    private final static QName _Login_QNAME = new QName("http://web/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://web/", "loginResponse");
    private final static QName _Logout_QNAME = new QName("http://web/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://web/", "logoutResponse");
    private final static QName _Register_QNAME = new QName("http://web/", "register");
    private final static QName _RegisterResponse_QNAME = new QName("http://web/", "registerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webwemser.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateMeet }
     * 
     */
    public CreateMeet createCreateMeet() {
        return new CreateMeet();
    }

    /**
     * Create an instance of {@link CreateMeetResponse }
     * 
     */
    public CreateMeetResponse createCreateMeetResponse() {
        return new CreateMeetResponse();
    }

    /**
     * Create an instance of {@link GetCategories }
     * 
     */
    public GetCategories createGetCategories() {
        return new GetCategories();
    }

    /**
     * Create an instance of {@link GetCategoriesResponse }
     * 
     */
    public GetCategoriesResponse createGetCategoriesResponse() {
        return new GetCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetMeet }
     * 
     */
    public GetMeet createGetMeet() {
        return new GetMeet();
    }

    /**
     * Create an instance of {@link GetMeetResponse }
     * 
     */
    public GetMeetResponse createGetMeetResponse() {
        return new GetMeetResponse();
    }

    /**
     * Create an instance of {@link GetMeets }
     * 
     */
    public GetMeets createGetMeets() {
        return new GetMeets();
    }

    /**
     * Create an instance of {@link GetMeetsByCategory }
     * 
     */
    public GetMeetsByCategory createGetMeetsByCategory() {
        return new GetMeetsByCategory();
    }

    /**
     * Create an instance of {@link GetMeetsByCategoryResponse }
     * 
     */
    public GetMeetsByCategoryResponse createGetMeetsByCategoryResponse() {
        return new GetMeetsByCategoryResponse();
    }

    /**
     * Create an instance of {@link GetMeetsByUser }
     * 
     */
    public GetMeetsByUser createGetMeetsByUser() {
        return new GetMeetsByUser();
    }

    /**
     * Create an instance of {@link GetMeetsByUserResponse }
     * 
     */
    public GetMeetsByUserResponse createGetMeetsByUserResponse() {
        return new GetMeetsByUserResponse();
    }

    /**
     * Create an instance of {@link GetMeetsResponse }
     * 
     */
    public GetMeetsResponse createGetMeetsResponse() {
        return new GetMeetsResponse();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link JoinMeet }
     * 
     */
    public JoinMeet createJoinMeet() {
        return new JoinMeet();
    }

    /**
     * Create an instance of {@link JoinMeetResponse }
     * 
     */
    public JoinMeetResponse createJoinMeetResponse() {
        return new JoinMeetResponse();
    }

    /**
     * Create an instance of {@link LeaveMeet }
     * 
     */
    public LeaveMeet createLeaveMeet() {
        return new LeaveMeet();
    }

    /**
     * Create an instance of {@link LeaveMeetResponse }
     * 
     */
    public LeaveMeetResponse createLeaveMeetResponse() {
        return new LeaveMeetResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link SessionResponse }
     * 
     */
    public SessionResponse createSessionResponse() {
        return new SessionResponse();
    }

    /**
     * Create an instance of {@link ReturnCodeResponse }
     * 
     */
    public ReturnCodeResponse createReturnCodeResponse() {
        return new ReturnCodeResponse();
    }

    /**
     * Create an instance of {@link SessionData }
     * 
     */
    public SessionData createSessionData() {
        return new SessionData();
    }

    /**
     * Create an instance of {@link UserData }
     * 
     */
    public UserData createUserData() {
        return new UserData();
    }

    /**
     * Create an instance of {@link MeetsResponse }
     * 
     */
    public MeetsResponse createMeetsResponse() {
        return new MeetsResponse();
    }

    /**
     * Create an instance of {@link Meet }
     * 
     */
    public Meet createMeet() {
        return new Meet();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link MeetResponse }
     * 
     */
    public MeetResponse createMeetResponse() {
        return new MeetResponse();
    }

    /**
     * Create an instance of {@link CategoriesResponse }
     * 
     */
    public CategoriesResponse createCategoriesResponse() {
        return new CategoriesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "createMeet")
    public JAXBElement<CreateMeet> createCreateMeet(CreateMeet value) {
        return new JAXBElement<CreateMeet>(_CreateMeet_QNAME, CreateMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "createMeetResponse")
    public JAXBElement<CreateMeetResponse> createCreateMeetResponse(CreateMeetResponse value) {
        return new JAXBElement<CreateMeetResponse>(_CreateMeetResponse_QNAME, CreateMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getCategories")
    public JAXBElement<GetCategories> createGetCategories(GetCategories value) {
        return new JAXBElement<GetCategories>(_GetCategories_QNAME, GetCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getCategoriesResponse")
    public JAXBElement<GetCategoriesResponse> createGetCategoriesResponse(GetCategoriesResponse value) {
        return new JAXBElement<GetCategoriesResponse>(_GetCategoriesResponse_QNAME, GetCategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeet")
    public JAXBElement<GetMeet> createGetMeet(GetMeet value) {
        return new JAXBElement<GetMeet>(_GetMeet_QNAME, GetMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetResponse")
    public JAXBElement<GetMeetResponse> createGetMeetResponse(GetMeetResponse value) {
        return new JAXBElement<GetMeetResponse>(_GetMeetResponse_QNAME, GetMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeets")
    public JAXBElement<GetMeets> createGetMeets(GetMeets value) {
        return new JAXBElement<GetMeets>(_GetMeets_QNAME, GetMeets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetsByCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetsByCategory")
    public JAXBElement<GetMeetsByCategory> createGetMeetsByCategory(GetMeetsByCategory value) {
        return new JAXBElement<GetMeetsByCategory>(_GetMeetsByCategory_QNAME, GetMeetsByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetsByCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetsByCategoryResponse")
    public JAXBElement<GetMeetsByCategoryResponse> createGetMeetsByCategoryResponse(GetMeetsByCategoryResponse value) {
        return new JAXBElement<GetMeetsByCategoryResponse>(_GetMeetsByCategoryResponse_QNAME, GetMeetsByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetsByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetsByUser")
    public JAXBElement<GetMeetsByUser> createGetMeetsByUser(GetMeetsByUser value) {
        return new JAXBElement<GetMeetsByUser>(_GetMeetsByUser_QNAME, GetMeetsByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetsByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetsByUserResponse")
    public JAXBElement<GetMeetsByUserResponse> createGetMeetsByUserResponse(GetMeetsByUserResponse value) {
        return new JAXBElement<GetMeetsByUserResponse>(_GetMeetsByUserResponse_QNAME, GetMeetsByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "getMeetsResponse")
    public JAXBElement<GetMeetsResponse> createGetMeetsResponse(GetMeetsResponse value) {
        return new JAXBElement<GetMeetsResponse>(_GetMeetsResponse_QNAME, GetMeetsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "joinMeet")
    public JAXBElement<JoinMeet> createJoinMeet(JoinMeet value) {
        return new JAXBElement<JoinMeet>(_JoinMeet_QNAME, JoinMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "joinMeetResponse")
    public JAXBElement<JoinMeetResponse> createJoinMeetResponse(JoinMeetResponse value) {
        return new JAXBElement<JoinMeetResponse>(_JoinMeetResponse_QNAME, JoinMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeaveMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "leaveMeet")
    public JAXBElement<LeaveMeet> createLeaveMeet(LeaveMeet value) {
        return new JAXBElement<LeaveMeet>(_LeaveMeet_QNAME, LeaveMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeaveMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "leaveMeetResponse")
    public JAXBElement<LeaveMeetResponse> createLeaveMeetResponse(LeaveMeetResponse value) {
        return new JAXBElement<LeaveMeetResponse>(_LeaveMeetResponse_QNAME, LeaveMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

}
