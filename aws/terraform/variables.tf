variable "ENVIRONMENT" {}
variable "AWS_ACCESS_KEY" {}
variable "AWS_SECRET_KEY" {}
variable "PATH_TO_PRIVATE_KEY" {}
variable "PATH_TO_PUBLIC_KEY" {}
variable "INSTANCE_USERNAME" {}
variable "INSTANCE_TYPE" {}
variable "SSH_CIDR" {
  default = "47.187.108.244/32"
}

variable "AWS_REGION" {
  default = "us-east-1"
}
variable "AWS_AZ" {
  default = "us-east-1a"
}
variable "DOMAIN" {
  default = "infracog.com"
}


  


