package ra.com.business;

import ra.com.dao.ProjectDAO;
import ra.com.dao.imp.ProjectDAOImp;
import ra.com.entity.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProjectServlet", value = "/ProjectServlet")
public class ProjectServlet extends HttpServlet {

    private final ProjectDAO projectDAO;
    public ProjectServlet() {
        projectDAO = new ProjectDAOImp();
    }

    public void findAllProjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Project> listProjects = projectDAO.findAll();
        req.setAttribute("listProjects", listProjects);
        req.getRequestDispatcher("views/projects.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllProjects(request, response);
        } else if (action.equals("Update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Project project = projectDAO.findProjectById(id);
            request.setAttribute("project", project);
            request.getRequestDispatcher("views/updateProject.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            int projectId = Integer.parseInt(request.getParameter("id"));
            boolean result = projectDAO.deleteProject(projectId);
            if (result) {
                findAllProjects(request, response);
            } else  {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
//      B1: lay du lieu form submit len server
            Project project = new Project();
            project.setName(request.getParameter("name"));
            project.setDescription(request.getParameter("description"));
            project.setImage(request.getParameter("image"));
//      B2: Goi sang DAO thuc hien them moi
            boolean result = projectDAO.addProject(project);
//      B3: xu ly ket qua tra ve
            if(result){
                findAllProjects(request,response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }else if (action.equals("Update")) {
            Project project = new Project();
            project.setId(Integer.parseInt(request.getParameter("id")));
            project.setName(request.getParameter("name"));
            project.setDescription(request.getParameter("description"));
            project.setImage(request.getParameter("image"));
            boolean result = projectDAO.updateProject(project);
            if(result){
                findAllProjects(request,response);
            } else  {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }

    }
}