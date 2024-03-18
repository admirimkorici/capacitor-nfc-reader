# nfcreader

NFC Reader Plugin for Ionic Capacitor app

## Install

```bash
npm install nfcreader
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`writeNfcTag(...)`](#writenfctag)
* [`startNfcReading(...)`](#startnfcreading)
* [`stopNfcReading(...)`](#stopnfcreading)
* [`setNfcDataCallback(...)`](#setnfcdatacallback)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### writeNfcTag(...)

```typescript
writeNfcTag(options: { data: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ data: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### startNfcReading(...)

```typescript
startNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### stopNfcReading(...)

```typescript
stopNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### setNfcDataCallback(...)

```typescript
setNfcDataCallback(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------

</docgen-api>
