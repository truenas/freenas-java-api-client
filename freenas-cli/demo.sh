#./freenas-cli.sh -volume add css01 -vname dev01
#./freenas-cli.sh -share add nfs /mnt/dev01/css01 "css01" sys


./freenas-cli.sh -share list all 
./freenas-cli.sh -volume add secdemo -vname zz
./freenas-cli.sh -share add nfs /mnt/zz/secdemo "secdemo" sys

./freenas-cli.sh -share list all 
./freenas-cli.sh -share list all  | grep secdemo
