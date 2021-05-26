FROM airhacks/glassfish
COPY ./target/football_project_v3.war ${DEPLOYMENT_DIR}
