data "aws_route53_zone" "selected" {
  name         = "${var.DOMAIN}"
  private_zone = false
}

locals {
  serverNameBase = "softli"
  envSuffix = "-${lower(var.ENVIRONMENT)}"
  nullSuffix = ""
#  serverNameSuffix = "${var.ENVIRONMENT == "PROD" ? locals.nullSuffix : locals.envSuffix}"
  serverNameSuffix = "${var.ENVIRONMENT == "PROD" ? local.nullSuffix : local.envSuffix}"
}

resource "aws_route53_record" "softli" {
  zone_id = "${data.aws_route53_zone.selected.zone_id}"
  name    = "softli${local.serverNameSuffix}.${var.DOMAIN}"
#  name    = "${var.ENVIRONMENT == "PROD" ? local.serverNameBase : local.envSuffix}"
  type    = "A"
  ttl     = "300"
  records = ["${aws_instance.SoftLi.public_ip}"]
}
