package com.example.user.salon;

public class Service {
        private String _id;
        private String name;
        private String description;
        private Integer service_time;
        private Integer clean_time;
        private String price;
        private Integer allow_excess;
        private Integer type;
        private Integer status;
        private Integer is_dependent;
        private String additional_services_number;
        private String created_at;
        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getService_time() {
            return service_time;
        }

        public void setService_time(Integer service_time) {
            this.service_time = service_time;
        }

        public Integer getClean_time() {
            return clean_time;
        }

        public void setClean_time(Integer clean_time) {
            this.clean_time = clean_time;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getAllow_excess() {
            return allow_excess;
        }

        public void setAllow_excess(Integer allow_excess) {
            this.allow_excess = allow_excess;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getIs_dependent() {
            return is_dependent;
        }

        public void setIs_dependent(Integer is_dependent) {
            this.is_dependent = is_dependent;
        }

        public String getAdditional_services_number() {
            return additional_services_number;
        }

        public void setAdditional_services_number(String additional_services_number) {
            this.additional_services_number = additional_services_number;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

    }

