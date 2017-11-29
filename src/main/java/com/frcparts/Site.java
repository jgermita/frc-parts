package com.frcparts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class Site {
  public String sha = "";
  private String url = "https://api.github.com/repos/jgermita/frc-parts/commits/master";

    public Site() {

                  String contents = "";

                  try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
                    String s = "";

                    while ((s = br.readLine()) != null) {
                      contents = contents.concat(s + "\n");
                      System.out.println("Sha: " + contents);
                      if(s.contains("\"sha\"")) {
                        break;
                      }
                    }

                    if(contents != null) {
                      contents = contents.split("\"sha\": \"")[1];
                      contents = contents.split("\",")[0];
                      System.out.println("\n\nSha: " + contents);
                      sha = contents.substring(0, 8);

                    }

                  } catch(Exception e) {

                  }

    }

    public String getSha() {
      return sha;
    }
}
