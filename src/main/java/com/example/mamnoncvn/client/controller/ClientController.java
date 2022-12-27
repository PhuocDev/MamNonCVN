package com.example.mamnoncvn.client.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.service.ChuongTrinhHocService;
import com.example.mamnoncvn.comment.Models.requests.CreateCommentRequest;
import com.example.mamnoncvn.comment.controller.CommentController;
import com.example.mamnoncvn.comment.entity.Comment;
import com.example.mamnoncvn.comment.service.CommentService;
import com.example.mamnoncvn.customer.entity.Customer;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.service.FeedbackService;
import com.example.mamnoncvn.mailSender.EmailService;
import com.example.mamnoncvn.mailSender.EmailServiceImp;
import com.example.mamnoncvn.mailSender.Mail;
import com.example.mamnoncvn.thoikhoabieu.entity.ThoiKhoaBieu;
import com.example.mamnoncvn.thoikhoabieu.service.ThoiKhoaBieuService;
import com.example.mamnoncvn.users.entity.AdminEmail;
import com.example.mamnoncvn.users.entity.User;
import com.example.mamnoncvn.users.repository.AdminEmailRepository;
import com.example.mamnoncvn.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ChuongTrinhHocService chuongTrinhHocService;
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    ThoiKhoaBieuService thoiKhoaBieuService;

    @GetMapping(path = {"/" })
    public String showTrangchu(Model model) {
        //CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        //model.addAttribute("createFeedbackRequest", new CreateFeedbackRequest());
        List<Blog> allBlog = blogService.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < Math.min(4, allBlog.size()); i++) {
            blogList.add(allBlog.get(i));
        }
        model.addAttribute("blogList", blogList);

        List<ChuongTrinhHoc> allCTH = chuongTrinhHocService.getAll();
        List<ChuongTrinhHoc> cthList = new ArrayList<>();
        for (int i = 0; i < Math.min(4, allCTH.size()); i++) {
            cthList.add(allCTH.get(i));
        }
        model.addAttribute("cthList", cthList);
        return "client/trangchu";
    }

    //đã hoàn thành
    @GetMapping("/tuvan")
    public String tuvan(Model model) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);
        return "client/tuvan";
    }
    // đã hoàn thành
    @GetMapping("/chuongtrinhhoc")
    public String chuongtrinhhoc(Model model, @RequestParam(required = false) String keyword) {
        List<ChuongTrinhHoc> chuongTrinhHocList = chuongTrinhHocService.getAll();
        if (keyword != null) {
            chuongTrinhHocList = chuongTrinhHocService.findAllByKeyword(keyword);
        }
        model.addAttribute("chuongTrinhHocList", chuongTrinhHocList);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/chuongtrinhhoc";
    }
    @GetMapping("/viewCthDetail")
    public String viewCthDetail(Model model, @PathParam("id") Long id) {
        ChuongTrinhHoc chuongTrinhHoc = chuongTrinhHocService.findChuongTrinhHocByID(id);
        if (chuongTrinhHoc == null)  throw new NotFoundException("Cannot found CTH id: " + id);
        model.addAttribute("chuongtrinhhoc", chuongTrinhHoc);
        return "client/cthDetail";
    }


    @GetMapping("/blog_thongbao")
    public String blog(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAllByCategory("thongbao");
        if (keyword != null) blogList = blogService.findAllInOneCategory("thongbao", keyword);
        model.addAttribute("blogList", blogList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/blog";
    }
    @GetMapping("/blog_all")
    public String blogAll(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAllByCategory("blog");
        if (keyword != null) blogList = blogService.findAllBlogs(keyword);
        model.addAttribute("blogList", blogList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/blog";
    }
    @GetMapping("/viewBlogDetail")
    public String viewBlogDetail(Model model, @PathParam("id") Long id) {
        Blog blog = blogService.findBlogById(id);
        if (blog == null)  throw new NotFoundException("Cannot found blog id: " + id);
        model.addAttribute("blog", blog);

        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        model.addAttribute("createCommentRequest", createCommentRequest);
        List<Comment> commentList = null;
        try {
            commentList = commentService.findAllByBlogId(blog.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.addAttribute("commentList", commentList);
        return "client/blogDetail";
    }
    @GetMapping("/viewTkbDetail")
    public String viewTkbDetail(Model model, @PathParam("id") Long id) {
        ThoiKhoaBieu tkb = thoiKhoaBieuService.findThoiKhoaBieuByID(id);
        if (tkb == null)  throw new NotFoundException("Cannot found tkb id: " + id);
        model.addAttribute("tkb", tkb);

        return "client/tkbDetail";
    }

    @GetMapping("/tkb")
    public String tkbAll(Model model, @RequestParam(required = false) String keyword) {
        List<ThoiKhoaBieu> tkbList = thoiKhoaBieuService.getAll();
        if (keyword != null) tkbList = thoiKhoaBieuService.findAllByKeyword(keyword);
        model.addAttribute("tkbList", tkbList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/thoikhoabieu";
    }


    @GetMapping("contact")
    public String contact(Model model){
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        return "client/contact";
    }
    @GetMapping("/gioithieu")
    public String gioithieu(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        Blog blog = blogService.findLatestBlogByCategory("gioithieu");
        if (blog != null)  {
            model.addAttribute("blog", blog);
            CreateCommentRequest createCommentRequest = new CreateCommentRequest();
            model.addAttribute("createCommentRequest", createCommentRequest);
            List<Comment> commentList = null;
            try {
                commentList = commentService.findAllByBlogId(blog.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            model.addAttribute("commentList", commentList);
            return "client/blogDetail";
        } else return "client/gioithieu";
    }

    @GetMapping("/tuyensinh")
    public String tuyensinh() {
        return "client/tuyensinh";
    }
    @GetMapping("/dangcapnhat")
    public String dangcapnhat(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        return "client/dangcapnhat";
    }
    @GetMapping("/thucdon")
    public String thucdon(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAllByCategory("thucdon");
        if (keyword != null) blogList = blogService.findAllInOneCategory("thucdon", keyword);
        model.addAttribute("blogList", blogList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/blog";
    }
    @GetMapping("/quytrinhtuyensinh")
    public String quytrinhTS(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        Blog blog = blogService.findLatestBlogByCategory("tuyensinh");
        if (blog != null)  {
            model.addAttribute("blog", blog);
            CreateCommentRequest createCommentRequest = new CreateCommentRequest();
            model.addAttribute("createCommentRequest", createCommentRequest);
            List<Comment> commentList = null;
            try {
                commentList = commentService.findAllByBlogId(blog.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            model.addAttribute("commentList", commentList);
            return "client/blogDetail";
        } else return "client/dangcapnhat";
    }
    @GetMapping("/hocphi")
    public String hocphithamkhao(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        Blog blog = blogService.findLatestBlogByCategory("hocphi");
        if (blog != null)  {
            model.addAttribute("blog", blog);
            CreateCommentRequest createCommentRequest = new CreateCommentRequest();
            model.addAttribute("createCommentRequest", createCommentRequest);
            List<Comment> commentList = null;
            try {
                commentList = commentService.findAllByBlogId(blog.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            model.addAttribute("commentList", commentList);
            return "client/blogDetail";
        } else return "client/dangcapnhat";
    }

    @GetMapping("/tuyendung")
    public String tuyendung(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        Blog blog = blogService.findLatestBlogByCategory("tuyendung");
        if (blog != null)  {
            model.addAttribute("blog", blog);
            CreateCommentRequest createCommentRequest = new CreateCommentRequest();
            model.addAttribute("createCommentRequest", createCommentRequest);
            List<Comment> commentList = null;
            try {
                commentList = commentService.findAllByBlogId(blog.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            model.addAttribute("commentList", commentList);
            return "client/blogDetail";
        } else return "client/dangcapnhat";
    }

    @Autowired
    EmailService emailService;

    @Autowired
    AdminEmailRepository adminEmailRepository;

    @GetMapping("/sendMailDemo")
    public String sendMail(Model model){
        Customer customer = customerService.getAll().get(0);
        List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
        Mail mail = new Mail();
        mail.setSubject("Một phụ huynh vừa đăng kí tư vấn");

        for (int i =0; i < 2; i++){
            mail.setRecipient(adminEmailList.get(i).getEmail());
            mail.setAttachment(null);
            mail.setMsgBody("Thông tin khách hàng" +
                    "\nTên khách hàng: " + customer.getTenPhuHuynh() +
                    "\nTên bé: " + customer.getTenBe() +
                    "\nĐộ tuổi: " + customer.getTuoiBe() +
                    "\nSố điện thoại: " + customer.getSoDienThoai()+
                    "\nĐịa chỉ: " + customer.getDiaChi() +
                    "\nNgày đăng kí: " + LocalDateTime.now()
            );
            emailService.sendSimpleMail(mail);
        }

        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);
        return "client/tuvan";
    }



    @PostMapping(path = "/comment/addFromClient",  consumes = "application/x-www-form-urlencoded")
    public String addNewCommentFromClient(Model model,@Valid @ModelAttribute("createCommentRequest") CreateCommentRequest createCommentRequest) {
        commentService.save(createCommentRequest);
        return "redirect:/client/viewBlogDetail?id=" + createCommentRequest.getBlogId();
    }
    @PostMapping(path = "/customer/addFromClient",  consumes = "application/x-www-form-urlencoded")
    public String addNewcustomerFromClient(Model model,@Valid @ModelAttribute("createCustomerRequest") CreateCustomerRequest createCustomerRequest) {
        customerService.save(createCustomerRequest);
        try {
            List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
            Mail mail = new Mail();
            mail.setSubject("Một phụ huynh vừa đăng kí tư vấn");
            if (adminEmailList.size() >= 1) {
                for (int i = 0; i < adminEmailList.size(); i++) {
                    mail.setRecipient(adminEmailList.get(i).getEmail());
                    mail.setAttachment(null);
                    mail.setMsgBody("Thông tin khách hàng" +
                            "\nTên khách hàng: " + createCustomerRequest.getTenPhuHuynh() +
                            "\nTên bé: " + createCustomerRequest.getTenBe() +
                            "\nĐộ tuổi: " + createCustomerRequest.getTuoiBe() +
                            "\nSố điện thoại: " + createCustomerRequest.getSoDienThoai() +
                            "\nĐịa chỉ: " + createCustomerRequest.getDiaChi() +
                            "\nGhi chú: " + createCustomerRequest.getGhiChu() +
                            "\nNgày đăng kí: " + LocalDateTime.now()
                    );
                    emailService.sendSimpleMail(mail);
                }
            } else {
                mail.setRecipient("nhuphuoc.bui@gmail.com");
                mail.setAttachment(null);
                mail.setMsgBody("Hiện tại danh sách admin chưa có, vui lòng bổ sung admin\n" +
                        "Thông tin khách hàng" +
                        "\nTên khách hàng: " + createCustomerRequest.getTenPhuHuynh() +
                        "\nTên bé: " + createCustomerRequest.getTenBe() +
                        "\nĐộ tuổi: " + createCustomerRequest.getTuoiBe() +
                        "\nSố điện thoại: " + createCustomerRequest.getSoDienThoai() +
                        "\nĐịa chỉ: " + createCustomerRequest.getDiaChi() +
                        "\nGhi chú: " + createCustomerRequest.getGhiChu() +
                        "\nNgày đăng kí: " + LocalDateTime.now()
                );
                emailService.sendSimpleMail(mail);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/client/";
    }
    @Autowired
    FeedbackService feedbackService;
    @PostMapping(path = "/feedback/addFromClient",  consumes = "application/x-www-form-urlencoded")
    public String addNewFeedbackFromClient(Model model,@Valid @ModelAttribute("createFeedbackRequest") CreateFeedbackRequest createFeedbackRequest) {

        feedbackService.save(createFeedbackRequest);
        try {
            List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
            Mail mail = new Mail();
            mail.setSubject("Một khách hàng đang cần liên hệ");
            if (adminEmailList.size()>= 1) {
                for (int i =0; i< adminEmailList.size();i++){
                    mail.setRecipient(adminEmailList.get(i).getEmail());
                    mail.setAttachment(null);
                    mail.setMsgBody("Thông tin khách hàng" +
                            "\nTên khách hàng: " + createFeedbackRequest.getName()+
                            "\nEmail: " + createFeedbackRequest.getEmail() +
                            "\nSố điện thoại: " + createFeedbackRequest.getSoDienThoai()+
                            "\nNội dung: " + createFeedbackRequest.getContent() +
                            "\nNgày đăng kí: " + LocalDateTime.now()
                    );
                    emailService.sendSimpleMail(mail);
                }
            } else {
                mail.setRecipient("nhuphuoc.bui@gmail.com");
                mail.setAttachment(null);
                mail.setMsgBody("Hiện tại danh sách quản trị viên đang trống, vui lòng bổ sung" +
                        "Thông tin khách hàng" +
                        "\nTên khách hàng: " + createFeedbackRequest.getName()+
                        "\nEmail: " + createFeedbackRequest.getEmail() +
                        "\nSố điện thoại: " + createFeedbackRequest.getSoDienThoai()+
                        "\nNội dung: " + createFeedbackRequest.getContent() +
                        "\nNgày đăng kí: " + LocalDateTime.now()
                );
                emailService.sendSimpleMail(mail);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/client/";
    }

}
