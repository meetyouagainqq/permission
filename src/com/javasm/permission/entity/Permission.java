package com.javasm.permission.entity;

import lombok.Data;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:28
 * @description
 */
@Data
public class Permission {
  private Integer id;
  private String perName;
  private String perUrl;
  private String perIdentity;
  private String perLogo;
  private Integer perStatus;
  private Integer parentPerId;
}
