// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;  
import com.google.gson.Gson;

/** Keeping this servlet so it can be reused for formatting */
@WebServlet("/dishId")
public class SpoonacularDishIdServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String query = request.getParameter("dishName");
    Client c = ClientBuilder.newClient();
    WebTarget target = c.target("https://api.spoonacular.com/recipes/search?query=" + query + "&number=2&apiKey=cd2269d31cb94065ad1e73ce292374a5");

    try {
      String recipeInfo = target.request(MediaType.APPLICATION_JSON).get(String.class);
      Gson gson = new Gson();
      response.setContentType("application/json");
      response.getWriter().println(gson.toJson(recipeInfo));
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}