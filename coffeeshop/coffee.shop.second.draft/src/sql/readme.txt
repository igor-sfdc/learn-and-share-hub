1. Install MySQL server (make a note of your admin account name and password)
2. Run the following batch-scripts using your admin account name and password:
<code>
	mysql -h host-name -u user-name -p < coffeedbSchema.sql
	mysql -h host-name -u user-name -p < coffeedbData.sql
	mysql -h host-name -u user-name -p < coffeedbUser.sql
</code>