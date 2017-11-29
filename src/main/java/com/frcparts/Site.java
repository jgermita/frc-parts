package com.frcparts;

import org.apache.commons.lang3.StringUtils;
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
                if(s.contains("\"sha\"")) {
                  break;
                }
              }

              if(contents != null) {
                contents = contents.split("\"sha\": \"")[1];
                contents = contents.split("\",")[0];

                sha = contents.substring(0, 8);

              }

            } catch(Exception e) {

            }

    }
}
