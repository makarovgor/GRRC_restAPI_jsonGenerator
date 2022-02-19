# GRRC_restAPI_jsonGenerator

if rest API cant open 
$> curl http://localhost:8080/api/generate?size=1000
try:
$> sudo lsof -nP -i4TCP:8080
$> kill -9 PID

if GRPC cant open get response 
try:
$> sudo lsof -nP -i4TCP:9000
$> kill -9 PID
