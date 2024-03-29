package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository mockCompanyRepository;

    @Test
    public void should_return_companies_when_request_all_companies_api() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"companyName\": \"baidu\",\n" +
                        "        \"employeesNumber\": 500,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"companyName\": \"wangyiyun\",\n" +
                        "        \"employeesNumber\": 100,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_all_employees_when_request_company_api_by_id() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies/1/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"zhangsan\",\n" +
                        "        \"age\": 18,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"lisi\",\n" +
                        "        \"age\": 25,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 7000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_companies_when_request_company_api_by_id() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"companyName\": \"alibaba\",\n" +
                        "    \"employeesNumber\": 200,\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"zhangsan\",\n" +
                        "            \"age\": 18,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 5000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"lisi\",\n" +
                        "            \"age\": 25,\n" +
                        "            \"gender\": \"female\",\n" +
                        "            \"salary\": 7000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void should_return_companies_when_request_company_by_page_and_page_size() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies?page=1&&pageSize=2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"companyName\": \"baidu\",\n" +
                        "        \"employeesNumber\": 500,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_the_update_company_when_update_company_by_id() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(put("/companies/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"companyName\": \"kugou\",\n" +
                        "\t\"employeesNumber\": 800,\n" +
                        "\t\"employees\": []\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"companyName\": \"kugou\",\n" +
                        "    \"employeesNumber\": 800,\n" +
                        "    \"employees\": []\n" +
                        "}"));
    }

    @Test
    public void should_return_the_add_company_when_call_add_company_api() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"companyName\": \"kugou\",\n" +
                        "\t\"employeesNumber\": 800,\n" +
                        "\t\"employees\": []\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 4,\n" +
                        "    \"companyName\": \"kugou\",\n" +
                        "    \"employeesNumber\": 800,\n" +
                        "    \"employees\": []\n" +
                        "}"));
    }

    @Test
    public void should_return_the_companies_when_delete_company_by_id() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1,"alibaba", 200, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2,"baidu", 500, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3,"wangyiyun", 100, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(delete("/companies/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"companyName\": \"wangyiyun\",\n" +
                        "        \"employeesNumber\": 100,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"zhangsan\",\n" +
                        "                \"age\": 18,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"lisi\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }
}
